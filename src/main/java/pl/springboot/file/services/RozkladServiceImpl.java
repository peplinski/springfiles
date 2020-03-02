package pl.springboot.file.services;


import org.springframework.stereotype.Service;
import pl.springboot.file.model.RodzajRozkladu;
import pl.springboot.file.repository.RozkladRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RozkladServiceImpl implements RozkladService {

    private RozkladRepository rozkladRepository;

    public RozkladServiceImpl(RozkladRepository rozkladRepository) {
        this.rozkladRepository = rozkladRepository;
    }

    @Override
    public List<RodzajRozkladu> findAll() {
        return (List<RodzajRozkladu>) rozkladRepository.findAll();
    }

    @Override
    public RodzajRozkladu save(RodzajRozkladu rodzajRozkladu) {
      return   rozkladRepository.save(rodzajRozkladu);

    }

    String findAllByTypRozkladu(String typRozkladu, String startLine, String godz) {
        List<RodzajRozkladu> rozkladList = new ArrayList<>();
        rozkladRepository.findAll().forEach(rozkladList::add);
        return rozkladList.stream()
                .filter(r -> r.getTypRozkladu().equals(typRozkladu) &&
                        r.getLinia().equals(startLine)
                        && r.getGodzina().equals(godz))
                .map(RodzajRozkladu::getMiejsceZmiany).findAny().orElse("");

    }

//    @Override
//    public boolean saveDataFromUploadFile(MultipartFile file) {
//        boolean isFlag = false;
//        String extention = FilenameUtils.getExtension(file.getOriginalFilename());
//        if (extention.equalsIgnoreCase("xls")
//                || extention.equalsIgnoreCase("xlsx")) {
//            isFlag = readDataFromExel(file);
//        }
//        return isFlag;
//    }

//    private boolean readDataFromExel(MultipartFile file) {
//        Workbook workbook = getWorkBook(file);
//        Sheet sheet = workbook.getSheetAt(0);
//        Iterator<Row> rows = sheet.iterator();
//        rows.next();
//        while (rows.hasNext()) {
//            Row row = rows.next();
//            RodzajRozkladu rodzajRozkladu = new RodzajRozkladu();
//            if (row.getCell(0).getCellTypeEnum() == CellType.STRING) {
//                rodzajRozkladu.setTypRozkladu(row.getCell(0).getStringCellValue().trim());
//            }
//            if (row.getCell(1).getCellTypeEnum() == CellType.STRING) {
//                rodzajRozkladu.setLinia(row.getCell(1).getStringCellValue());
//            }
//            if (row.getCell(2).getCellTypeEnum() == CellType.STRING) {
//                rodzajRozkladu.setBrygada(row.getCell(2).getStringCellValue());
//            }
//            if (row.getCell(3).getCellTypeEnum() == CellType.STRING) {
//                rodzajRozkladu.setGodzina(row.getCell(3).getStringCellValue());
//            }
//            if (row.getCell(4).getCellTypeEnum() == CellType.STRING) {
//                rodzajRozkladu.setMiejsceZmiany(row.getCell(4).getStringCellValue());
//            }
//            if (row.getCell(5).getCellTypeEnum() == CellType.STRING) {
//                rodzajRozkladu.setPierwszaLinia(row.getCell(5).getStringCellValue());
//            }
//            rozkladRepository.save(rodzajRozkladu);
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
}
