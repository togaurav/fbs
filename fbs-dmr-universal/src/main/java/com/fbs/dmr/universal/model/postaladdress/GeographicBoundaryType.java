package com.fbs.dmr.universal.model.postaladdress;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GEO_BOUNDARY_TYPE")
public class GeographicBoundaryType implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    private String description ="";

    public GeographicBoundaryType()
    {
    	
    }
    
    
    public Integer getId()
    {
    	return id;
    }

	public void setId(Integer id)
    {
    	this.id = id;
    }

	public String getDescription()
    {
    	return description;
    }

	public void setDescription(String description)
    {
    	this.description = description;
    }

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}

		if (!(obj instanceof GeographicBoundaryType))
		{
			return false;
		}

		GeographicBoundaryType other = (GeographicBoundaryType) obj;
		
		if (this.getId() == null && other.getId() == null)
		{
			return this.getDescription().equals(other.getDescription());
		}

		if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id))
		{
			return false;
		}
		
		return true;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		int descrHashCode = (this.description == null) ? 0 : this.description.hashCode();

		result = prime * result + ((id == null) ? descrHashCode : id.hashCode());

		return result;
	}


	public String toString()
	{
		return String.format("GeographicBoundaryType [id=%s, description=%s]", this.id, this.description);
	}
}
