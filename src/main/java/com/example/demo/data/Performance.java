package com.example.demo.data;


import com.example.demo.dto.PerformanceDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "performances")
public class Performance {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "country")
    private String country;

    public PerformanceDto toDto() {
        return PerformanceDto.builder()
                .id(this.id)
                .name(this.name)
                .country(this.country)
                .genre(this.genre)
                .build();
    }
}
