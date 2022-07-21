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
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "tbl_payment")
@NamedEntityGraphs(@NamedEntityGraph(
    name = "payment-user",
    attributeNodes = {
        @NamedAttributeNode("user")
    }
))
public class Payment implements Serializable {

    private static final long serialVersionUID = 42L;

    @Id
    @SequenceGenerator( name = "payment_sequence", sequenceName = "payment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_sequence")
    private Long id;

    @NotNull
    private String paymentType;
    private String provider;
    @Range(min=0, max=10)
    private Long accountNo;
    private String expiryDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payemnt_user_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = "payments")
    private User user;
}
