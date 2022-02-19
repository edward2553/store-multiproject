package co.com.poli.serviceshopping.entities;

import co.com.poli.serviceshopping.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "invoice_items")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "quantity")
    private Double quantity;
    @Column(name = "price")
    private Double price;
    @Column(name = "product_id")
    private Long productId;
    @Transient
    private Product product;
    @Transient
    private Double subTotal;

    public Double getSubTotal(){
        if(this.price>0 && this.quantity>0){
            return this.quantity*this.price;
        }else{
            return (double) 0;
        }
    }

    public InvoiceItem() {
        this.price = (double) 0;
        this.quantity = (double) 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
