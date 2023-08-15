package com.bidCircle.backend.service;

import com.bidCircle.backend.entity.Item;
import com.bidCircle.backend.model.BidModel;
import com.bidCircle.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BidderServiceImpl implements BidderService {
    @Autowired
    private ItemRepository itemRepository;



    @Override
    public void addBid(BidModel bidModel) {
        Optional<Item> itemOptional = itemRepository.findById(Long.parseLong(bidModel.getId()));
        Item item = itemOptional.orElseThrow(() -> new NoSuchElementException("Item not found"));
        item.setStartPrice(Integer.parseInt(bidModel.getPrice()));
        itemRepository.save(item);

    }
}
