package io.educative.mediaapp.model;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// an annotation from the Lombok library that generates common methods such as getters, 
//setters, equals(), hashCode(), and toString() for the class. 
//It reduces boilerplate code in your class.
@Data
// indicates that this class is a JPA entity. 
//Entities are used to map Java objects to database tables.
@Entity
// specifies the name of the database table to which this entity is mapped. 
// In this case, the table name is "playlist."
@Table(name = "playlist")
public class Playlist {

	// configure how the primary key (id) for this entity is generated
	// GenerationType.AUTO tells JPA to choose an appropriate strategy for primary key generation based on the database in use
	@GeneratedValue(strategy = GenerationType.AUTO)
	// designates the id field as the primary key for this entity
	// It uniquely identifies each Playlist record in the database.
	@Id
	private BigInteger id;

	private String name;

	// specifies the mapping of the createdOn field to a database column. 
	// It renames the column to "created_on."
	@Column(name = "created_on")
	// when this entity is serialized to JSON, the field should be named "created_on" in the JSON output.
	@JsonProperty("created_on")
	private Date createdOn;

	// define a collection of simple elements (not entities) associated with the Playlist
	@ElementCollection(targetClass = java.util.HashSet.class)
	@OneToMany(cascade = CascadeType.ALL)
	// specify the column that represents the foreign key relationship between the Playlist entity and the Song entity.
	@JoinColumn
	private Collection<Song> songs;

}