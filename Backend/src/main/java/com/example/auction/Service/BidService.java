package com.example.auction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.auction.DTOModels.BidDTO;
import com.example.auction.Models.Auction;
import com.example.auction.Models.Bid;
import com.example.auction.Models.User;
import com.example.auction.Repository.AuctionRepository;
import com.example.auction.Repository.BidRepository;
import com.example.auction.Repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private UserRepository userRepository;


    public List<BidDTO> getBidsForAuction(Long auctionId) {
        List<Bid> bids = bidRepository.findByAuctionId(auctionId);

        return bids.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    public BidDTO getBidById(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElse(null);
        if (bid == null) {
            return null;
        }
        return mapEntityToDto(bid);
    }

    public String addBid(Bid bid, Long auctionId, Long userId) {
        if (auctionId != null && userId != null && bid != null) {
            Auction auction = auctionRepository.getReferenceById(auctionId);
            User user = userRepository.getReferenceById(userId);
            bid.setBidder(user);
            bid.setAuction(auction);
            
            bidRepository.save(bid);
            return "Done";
        } else {
            return "error";
        }
    }

    public void updateBid(Long bidId,Double price) {
        Bid bid = bidRepository.findById(bidId).orElse(null);
        if (bid != null) {
            bid.setBidAmount(price);
            bidRepository.save(bid);
        }
    }

    private BidDTO mapEntityToDto(Bid bid) {
        return new BidDTO(
                bid.getBidId(),
                bid.getAuction().getAuctionId(),
                bid.getBidder().getUserId(),
                bid.getBidAmount(),
                bid.getBidTime()
        );
    }

    // private Bid mapDtoToEntity(BidDTO bidDTO) {
    //     Auction auction = auctionRepository.findById(bidDTO.getAuctionId()).orElse(null);

    //     User user = userRepository.findById(bidDTO.getBidderId()).orElse(null);
    //     if (auction == null || user == null) {
    //         return null;
    //     }

    //     Bid bid = new Bid();
    //     bid.setAuction(auction);
    //     bid.setBidder(user);
    //     bid.setBidAmount(bidDTO.getBidAmount());
    //     bid.setBidTime(bidDTO.getBidTime());
    //     return bid;
    // }
}
