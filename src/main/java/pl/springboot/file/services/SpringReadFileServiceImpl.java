package pl.springboot.file.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.repository.SpringReadFileRepository;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class SpringReadFileServiceImpl implements SpringReadFileService {

    private SpringReadFileRepository springReadFileRepository;

    public SpringReadFileServiceImpl(SpringReadFileRepository springReadFileRepository) {
        this.springReadFileRepository = springReadFileRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return (List<Schedule>) springReadFileRepository.findAll();
    }

    @Override
    public boolean saveDataFromUploadFile(MultipartFile file) {
        boolean isFlag = false;
        String extention = FilenameUtils.getExtension(file.getOriginalFilename());
        if (extention.equalsIgnoreCase("json")) {
            isFlag = readDataFromJson(file);
        } else if (extention.equalsIgnoreCase("csv")) {
            isFlag = readDataFromCsv(file);
        } else if (extention.equalsIgnoreCase("xls")
                || extention.equalsIgnoreCase("xlsx")) {
            isFlag = readDataFromExel(file);
        }


        return isFlag;
    }

    private boolean readDataFromExel(MultipartFile file) {
        Workbook workbook = getWorkBook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()){
            Row row = rows.next();
            Schedule schedule = new Schedule();
            if (row.getCell(0).getCellTypeEnum()== CellType.STRING){
                schedule.setFirstName(row.getCell(0).getStringCellValue().trim());
            }
            if (row.getCell(1).getCellTypeEnum()== CellType.STRING){
                schedule.setLastName(row.getCell(1).getStringCellValue());
            }
            if (row.getCell(2).getCellTypeEnum()== CellType.STRING){
                schedule.setEmail(row.getCell(2).getStringCellValue());
            }
            if (row.getCell(3).getCellTypeEnum()== CellType.NUMERIC){
                String phoneNumber = NumberToTextConverter.toText(row.getCell(3).getNumericCellValue());
                schedule.setPhoneNumber(phoneNumber);
            }else if (row.getCell(3).getCellTypeEnum()==CellType.STRING){
                schedule.setPhoneNumber(row.getCell(3).getStringCellValue());
            }
            schedule.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
            springReadFileRepository.save(schedule);

        }
        return true;
    }

    private Workbook getWorkBook(MultipartFile file) {
        Workbook workbook = null;
        String extenion = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
            if (extenion.equalsIgnoreCase("xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());

            } else if (extenion.equalsIgnoreCase("xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    private boolean readDataFromCsv(MultipartFile file) {
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();
            List<String[]> rows = csvReader.readAll();
            for (String[] row : rows) {
                if (row.length<0)
                    continue;
                springReadFileRepository.save(
                        new Schedule(row[0], row[1], row[2], row[3],
                                FilenameUtils.getExtension(file.getOriginalFilename())));
                System.out.println(row);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean readDataFromJson(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            List<Schedule> schedules = Arrays.asList(mapper.readValue(inputStream, Schedule[].class));
            if (schedules != null && schedules.size() > 0) {
                for (Schedule schedule : schedules) {
                    schedule.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
                    springReadFileRepository.save(schedule);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
