package br.com.zaul.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.lang.Override;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Todo implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @Column
   private String task;

   @Column
   private String description;

   @Temporal(TemporalType.TIMESTAMP)
   private Date createdOn;

   @Column
   private boolean completed;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((Todo) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public String getTask()
   {
      return this.task;
   }

   public void setTask(final String task)
   {
      this.task = task;
   }

   public String getDescription()
   {
      return this.description;
   }

   public void setDescription(final String description)
   {
      this.description = description;
   }

   public Date getCreatedOn()
   {
      return this.createdOn;
   }

   public void setCreatedOn(final Date createdOn)
   {
      this.createdOn = createdOn;
   }

   public boolean getCompleted()
   {
      return this.completed;
   }

   public void setCompleted(final boolean completed)
   {
      this.completed = completed;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (task != null && !task.trim().isEmpty())
         result += "task: " + task;
      if (description != null && !description.trim().isEmpty())
         result += ", description: " + description;
      result += ", completed: " + completed;
      return result;
   }
}