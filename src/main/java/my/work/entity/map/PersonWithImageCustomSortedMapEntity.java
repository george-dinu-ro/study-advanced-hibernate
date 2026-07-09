package my.work.entity.map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SortComparator;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

@Entity
@Table(name = "person_with_image_map_tab")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PersonWithImageCustomSortedMapEntity {

    public static class DescStringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @ElementCollection
    @CollectionTable(name = "image_map_tab", joinColumns = @JoinColumn(name = "person_id"))
    @MapKeyColumn(name = "file_name")
    @Column(name = "file_description")
    @SortComparator(DescStringComparator.class)
    private SortedMap<String, String> images = new TreeMap<>();

}
