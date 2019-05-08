package com.capgemini.springbootmicroserviceforexservice.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springbootmicroserviceforexservice.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>
{
	ExchangeValue findByFromAndTo(String from, String to);
}
