package com.ecommerce.ecommerceTTS.model;

public class Role {
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class Role {
        // this here allows the Id to be auto generated
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "role_id")
        private Long id;
        private String role;
    }
}
