package com.HealthCare.HealthyLife_Backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "food") // 실제 데이터베이스 테이블 이름에 맞게 지정해야 합니다.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long num;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "class1")
    private String class1;

    @Column(name = "class2")
    private String class2;

    @Column(name = "serving_size")
    private String servingSize;

    @Column(name = "serving_unit")
    private String servingUnit;

    @Column(name = "kcal")
    private String kcal;

    @Column(name = "protein")
    private String protein;

    @Column(name = "province")
    private String province;

    @Column(name = "carbohydrate")
    private String carbohydrate;

    @Column(name = "sugar")
    private String sugar;

    @Column(name = "dietary_fiber")
    private String dietaryFiber;

    @Column(name = "calcium")
    private String calcium;

    @Column(name = "iron")
    private String iron;

    @Column(name = "salt")
    private String salt;

    @Column(name = "zinc")
    private String zinc;

    @Column(name = "vita_b1")
    private String vitaB1;

    @Column(name = "vit_b2")
    private String vitaB2;

    @Column(name = "vita_b12")
    private String vitaB12;

    @Column(name = "vita_c")
    private String vitaC;

    @Column(name = "cholesterol")
    private String cholesterol;

    @Column(name = "saturated_fat")
    private String saturatedFat;

    @Column(name = "trans_fat")
    private String transFat;

    @Column(name = "issuer")
    private String issuer;

}
