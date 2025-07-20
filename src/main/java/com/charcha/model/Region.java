package com.charcha.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {

    @Id
    private String regionName;       // e.g., Gorakhpur, Varanasi
    private int userCount;
    private LocalDateTime lastActive;
}
