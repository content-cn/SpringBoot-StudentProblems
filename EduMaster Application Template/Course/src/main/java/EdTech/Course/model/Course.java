package EdTech.Course.model;

import javax.persistence.*;

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String instructor;
    private Long amount;

}
