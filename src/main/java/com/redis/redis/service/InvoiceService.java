package com.redis.redis.service;

import com.redis.redis.entity.Invoice;

import java.util.List;

public interface InvoiceService {
  public Invoice saveInvoice(Invoice inv);
  public Invoice updateInvoice(Invoice inv, Integer invId);
  public void deleteInvoice(Integer invId);
  public Invoice getOneInvoice(Integer invId);
  public List<Invoice> getAllInvoices();
}
