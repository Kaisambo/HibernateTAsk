package hiber.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne
   @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
   @JoinColumn(name = "car_id", referencedColumnName = "id")
   private Car car;

   public User() {}
   
   public User( String firstName, String lastName, String email ) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
}
