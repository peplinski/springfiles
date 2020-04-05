package pl.springboot.file.services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.springboot.file.model.RodzajRozkladu;
import pl.springboot.file.model.Schedule;
import pl.springboot.file.repository.RozkladRepository;
import pl.springboot.file.repository.ScheduleRepository;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository scheduleRepository;
    private RozkladRepository rozkladRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, RozkladRepository rozkladRepository) {
        this.scheduleRepository = scheduleRepository;
        this.rozkladRepository = rozkladRepository;
    }

    @Override
    public List<Schedule> findAll() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public boolean saveDataFromCsv(MultipartFile file, String date, String typRozkladu) {
        List<Schedule> scheduleList = new ArrayList<>();
        try {
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';')
                    .withRecordSeparator(";").withIgnoreEmptyLines());

            for (CSVRecord record : csvParser) {
                Schedule schedule = new Schedule();
                schedule.setDate(date);
                schedule.setTypRozkladu(typRozkladu);
                schedule.setNrSluzbowy(record.get(0));
                schedule.setLinia(record.get(1).trim());
                schedule.setPoczatekPracy(record.get(2).trim());
                schedule.setKoniecPracy(record.get(3).trim());
                schedule.setMiejsceZmiany(findAllByTypRozkladu(schedule.getTypRozkladu(), schedule.getLinia(), schedule.getPoczatekPracy()));
                if (record.get(0).isEmpty())
                    continue;

                scheduleList.add(schedule);
            }
            scheduleRepository.saveAll(scheduleList);
            csvParser.close();
            reader.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public void deleteById(Long idToDelete) {
        scheduleRepository.deleteById(idToDelete);
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public Set<Schedule> findScheduleByNrSluzbowy(String nrSluzbowy) {
        return scheduleRepository.findScheduleByNrSluzbowy(nrSluzbowy).stream().collect(Collectors.toSet());
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
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

    @Override
    public List<Schedule> findByDate(String date) {
        List<Schedule> schedules = new ArrayList<>();
        return null;
    }
}
