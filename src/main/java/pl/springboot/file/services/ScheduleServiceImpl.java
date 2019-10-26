package pl.springboot.file.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.repository.ScheduleRepository;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public boolean readDataFromCsv(MultipartFile file, String date) {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';')
                    .withRecordSeparator(";").withIgnoreEmptyLines());

            for (CSVRecord record : csvParser) {
                Schedule schedule = new Schedule();
                schedule.setDate(date);
                schedule.setRodzajRozkladu("niedziela");
                schedule.setNrSluzbowy(record.get(0).trim());
                schedule.setLinia(record.get(1).trim());
                schedule.setPoczatekPracy(record.get(2).trim());
                schedule.setKoniecPracy(record.get(3).trim());
                if (record.get(0).isEmpty())
                    continue;

                scheduleList.add(schedule);

            }
            scheduleRepository.saveAll(scheduleList);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    @Override
//    public boolean saveDataFromUploadFile(MultipartFile file) {
//        boolean isFlag = false;
//        String extention = FilenameUtils.getExtension(file.getOriginalFilename());
//        if (extention.equalsIgnoreCase("json")) {
//            isFlag = readDataFromJson(file);
//        } else if (extention.equalsIgnoreCase("csv")) {
//            isFlag = readDataFromCsv(file);
//        } else if (extention.equalsIgnoreCase("xls")
//                || extention.equalsIgnoreCase("xlsx")) {
//            isFlag = readDataFromExel(file);
//        }
//
//
//        return isFlag;
//    }

//    private boolean readDataFromExel(MultipartFile file) {
//        Workbook workbook = getWorkBook(file);
//        Sheet sheet = workbook.getSheetAt(0);
//        Iterator<Row> rows = sheet.iterator();
//        rows.next();
//        while (rows.hasNext()){
//            Row row = rows.next();
//            Schedule schedule = new Schedule();
//            if (row.getCell(0).getCellTypeEnum()== CellType.STRING){
//                schedule.setFirstName(row.getCell(0).getStringCellValue().trim());
//            }
//            if (row.getCell(1).getCellTypeEnum()== CellType.STRING){
//                schedule.setLastName(row.getCell(1).getStringCellValue());
//            }
//            if (row.getCell(2).getCellTypeEnum()== CellType.STRING){
//                schedule.setEmail(row.getCell(2).getStringCellValue());
//            }
//            if (row.getCell(3).getCellTypeEnum()== CellType.NUMERIC){
//                String phoneNumber = NumberToTextConverter.toText(row.getCell(3).getNumericCellValue());
//                schedule.setPhoneNumber(phoneNumber);
//            }else if (row.getCell(3).getCellTypeEnum()==CellType.STRING){
//                schedule.setPhoneNumber(row.getCell(3).getStringCellValue());
//            }
//            schedule.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
//            scheduleRepository.save(schedule);
//
//        }
//        return true;
//    }

//    private Workbook getWorkBook(MultipartFile file) {
//        Workbook workbook = null;
//        String extenion = FilenameUtils.getExtension(file.getOriginalFilename());
//        try {
//            if (extenion.equalsIgnoreCase("xlsx")) {
//                workbook = new XSSFWorkbook(file.getInputStream());
//
//            } else if (extenion.equalsIgnoreCase("xls")) {
//                workbook = new HSSFWorkbook(file.getInputStream());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return workbook;
//    }

//    private boolean readDataFromJson(MultipartFile file) {
//        try {
//            InputStream inputStream = file.getInputStream();
//            ObjectMapper mapper = new ObjectMapper();
//            List<Schedule> schedules = Arrays.asList(mapper.readValue(inputStream, Schedule[].class));
//            if (schedules != null && schedules.size() > 0) {
//                for (Schedule schedule : schedules) {
//                    scheduleRepository.save(schedule);
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
