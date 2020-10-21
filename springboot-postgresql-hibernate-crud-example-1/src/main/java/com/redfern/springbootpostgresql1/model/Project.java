package com.redfern.springbootpostgresql1.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

		//MEMBER VARIABLES
		@Id
		@GeneratedValue(generator="project_id_seq", strategy=GenerationType.SEQUENCE)
		@SequenceGenerator(
				name = "project_id_seq",
				sequenceName="project_id_seq",
				allocationSize=1
				)
		private Long id;
		
		@Column(name="title")
		private String title;
		
		@ManyToMany(mappedBy = "projects") //mapped to List<Project> projects in Employee
		private List<Employee> employees;
		
		public Project() {
			super();
		}

		public Project(String title) {
			super();
			this.title = title;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
}
