//package com.prosmv.domain;
//
//import java.io.Serializable;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class UserFactory implements Serializable{
//	
//	private static final long serialVersionUID = -8880183738187486583L;
//	@Id
//	private Long id;
//	@ManyToOne
//	private User user;
//	@ManyToOne
//	private Factory factory;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public Factory getFactory() {
//		return factory;
//	}
//	public void setFactory(Factory factory) {
//		this.factory = factory;
//	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((factory == null) ? 0 : factory.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((user == null) ? 0 : user.hashCode());
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UserFactory other = (UserFactory) obj;
//		if (factory == null) {
//			if (other.factory != null)
//				return false;
//		} else if (!factory.equals(other.factory))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (user == null) {
//			if (other.user != null)
//				return false;
//		} else if (!user.equals(other.user))
//			return false;
//		return true;
//	}
//	
//	@Override
//	public String toString() {
//		return "UserFactory [id=" + id + ", user=" + user + ", factory=" + factory + "]";
//	}
//}
