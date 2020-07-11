package com.betterprojectsfaster.talks.openj9memory.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;
import com.betterprojectsfaster.talks.openj9memory.domain.enumeration.ProductCategory;

/**
 * A DTO for the {@link com.betterprojectsfaster.talks.openj9memory.domain.Product} entity.
 */
public class ProductDTO implements Serializable {
    
    private Long id;

    @NotNull
    @Size(min = 2, max = 90)
    private String name;

    @NotNull
    @DecimalMin(value = "0")
    private Float price;

    
    @Lob
    private String description;

    
    @Lob
    private byte[] picture;

    private String pictureContentType;
    @Lob
    private byte[] specification;

    private String specificationContentType;
    private ProductCategory category;

    @NotNull
    @Min(value = 0)
    private Integer inventory;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPictureContentType() {
        return pictureContentType;
    }

    public void setPictureContentType(String pictureContentType) {
        this.pictureContentType = pictureContentType;
    }

    public byte[] getSpecification() {
        return specification;
    }

    public void setSpecification(byte[] specification) {
        this.specification = specification;
    }

    public String getSpecificationContentType() {
        return specificationContentType;
    }

    public void setSpecificationContentType(String specificationContentType) {
        this.specificationContentType = specificationContentType;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProductDTO)) {
            return false;
        }

        return id != null && id.equals(((ProductDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProductDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", price=" + getPrice() +
            ", description='" + getDescription() + "'" +
            ", picture='" + getPicture() + "'" +
            ", specification='" + getSpecification() + "'" +
            ", category='" + getCategory() + "'" +
            ", inventory=" + getInventory() +
            "}";
    }
}
