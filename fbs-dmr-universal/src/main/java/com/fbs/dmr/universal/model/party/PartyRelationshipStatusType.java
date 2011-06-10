package com.fbs.dmr.universal.model.party;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fbs.dmr.universal.model.type.StatusType;

@Entity
@Table(name = "PARTY_RELATIONSHIP_STATUS_TYPES")
public class PartyRelationshipStatusType extends StatusType
{
    private static final long serialVersionUID = 1L;
    
    public PartyRelationshipStatusType()
    {
    	
    }

    public String toString()
	{
		return String.format("PartyRelationshipStatusType [id=%s]", this.getId());
	}
}