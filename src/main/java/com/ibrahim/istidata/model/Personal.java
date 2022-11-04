package com.ibrahim.istidata.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table ( name = "personals")
@Entity

public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column( name = "nik", unique = true )
    private String nik;

    @Column( name = "full_name" )
    private String fullName;

    @Column( name = "age" )
    private String age;

    @Column( name = "born" )
    private String born;

    @Column( name = "gender" )
    private String gender;

    @Column( name = "address", length = 1000)
    private String address;

    @Column( name = "country" )
    private String country;
}
