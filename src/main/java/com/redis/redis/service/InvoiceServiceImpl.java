package com.redis.redis.service;

import com.redis.redis.Respository.InvoiceRepository;
import com.redis.redis.entity.Invoice;
import com.redis.redis.exception.InvoiceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepo;

  @Override
  public Invoice saveInvoice(Invoice inv) {

    return invoiceRepo.save(inv);
  }


  @Override
  @CacheEvict(value = "Invoice", key = "#invId")
//  @CacheEvict(value = "Invoice", allEntries = true) //in case there are multiple records to delete
  public void deleteInvoice(Integer invId) {
    Invoice invoice = invoiceRepo.findById(invId)
        .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
    invoiceRepo.delete(invoice);
  }

  @Override
  @Cacheable(value = "Invoice", key = "#invId")
  public Invoice getOneInvoice(Integer invId) {
    Invoice invoice = invoiceRepo.findById(invId)
        .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
    return invoice;
  }

  @Override
  @Cacheable(value = "Invoice")
  public List<Invoice> getAllInvoices() {
    log.info("get data from db");
    return invoiceRepo.findAll();
  }

  @Override
  @CachePut(value = "Invoice", key = "#invId")
  public Invoice updateInvoice(Invoice inv, Integer invId) {
    log.info("modify record");
    Invoice invoice = invoiceRepo.findById(invId)
        .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
    invoice.setInvAmount(inv.getInvAmount());
    invoice.setInvName(inv.getInvName());
    return invoiceRepo.save(invoice);
  }
//  @Autowired
//  public void refreshCache(String cacheName) {
//    Cache cache = cacheManager.getCache(cacheName);
//    if (cache != null) {
//      cache.clear(); // Clears all entries from the cache, effectively refreshing it
//    }
//}
}