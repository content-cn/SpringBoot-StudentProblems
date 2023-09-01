package EdTech.Course.model;

import javax.persistence.*;
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;

}
