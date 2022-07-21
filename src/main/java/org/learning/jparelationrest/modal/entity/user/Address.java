package org.learning.jparelationrest.modal.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_address")
@NamedEntityGraphs(@NamedEntityGraph(
    name = "address-user",
    attributeNodes = {
        @NamedAttributeNode("user")
    }
))
public class Address implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @SequenceGenerator( name = "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;

    @NotNull
    private String city;
    @NotNull
    private String country;
    private Long mobile;
    @NotNull
    private String addressLine1;
    private String addressLine2;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "add_user_id")
    @JsonIgnoreProperties(value = "address")
    private User user;
}
