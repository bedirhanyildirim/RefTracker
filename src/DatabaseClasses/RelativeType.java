/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author burak_000
 */
@Entity
@Table(name = "relative_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelativeType.findAll", query = "SELECT r FROM RelativeType r")
    , @NamedQuery(name = "RelativeType.findById", query = "SELECT r FROM RelativeType r WHERE r.id = :id")
    , @NamedQuery(name = "RelativeType.findByName", query = "SELECT r FROM RelativeType r WHERE r.name = :name")})
public class RelativeType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public RelativeType() {
    }

    public RelativeType(Integer id) {
        this.id = id;
    }

    public RelativeType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelativeType)) {
            return false;
        }
        RelativeType other = (RelativeType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabaseClasses.RelativeType[ id=" + id + " ]";
    }
    
}
