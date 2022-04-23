package com.example.demo.helper;

import com.example.demo.dto.PetrolStationDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CSVHelper {

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {

        return TYPE.equals(file.getContentType());
    }

    public static List<PetrolStationDto> csvToPetrolStation(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter('|'))) {
            List<PetrolStationDto> stations = new ArrayList<PetrolStationDto>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
               // PetrolStationDto station = new PetrolStationDto(csvRecord.get(0), Double.parseDouble(csvRecord.get(1)), Double.parseDouble(csvRecord.get(3)), csvRecord.get(4), csvRecord.get(5), csvRecord.get(6), csvRecord.get(7));
                PetrolStationDto station = new PetrolStationDto(csvRecord.get("address"), Double.parseDouble(csvRecord.get("latitude")), Double.parseDouble(csvRecord.get("longtitude")), csvRecord.get("name"), csvRecord.get("country"), csvRecord.get("phone"), csvRecord.get("region"));

                stations.add(station);
            }

            return stations;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
