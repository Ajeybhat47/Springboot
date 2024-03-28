// import java.util.Date;
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;

// // Define User class
// class User {
//     private int userId;
//     private String username;
//     private String password;
//     private String email;
//     private String role;
    
//     // Constructor
//     public User(int userId, String username, String password, String email, String role) {
//         this.userId = userId;
//         this.username = username;
//         this.password = password;
//         this.email = email;
//         this.role = role;
//     }
    
//     // Getters and setters
//     public int getUserId() {
//         return userId;
//     }
    
//     public void setUserId(int userId) {
//         this.userId = userId;
//     }
    
//     public String getUsername() {
//         return username;
//     }
    
//     public void setUsername(String username) {
//         this.username = username;
//     }
    
//     public String getPassword() {
//         return password;
//     }
    
//     public void setPassword(String password) {
//         this.password = password;
//     }
    
//     public String getEmail() {
//         return email;
//     }
    
//     public void setEmail(String email) {
//         this.email = email;
//     }
    
//     public String getRole() {
//         return role;
//     }
    
//     public void setRole(String role) {
//         this.role = role;
//     }
// }

// // Define Item class
// class Item {
//     private int itemId;
//     private String itemName;
//     private String description;
//     private double initialPrice;
//     private int sellerId;
    
//     // Constructor
//     public Item(int itemId, String itemName, String description, double initialPrice, int sellerId) {
//         this.itemId = itemId;
//         this.itemName = itemName;
//         this.description = description;
//         this.initialPrice = initialPrice;
//         this.sellerId = sellerId;
//     }
    
//     // Getters and setters
//     public int getItemId() {
//         return itemId;
//     }
    
//     public void setItemId(int itemId) {
//         this.itemId = itemId;
//     }
    
//     public String getItemName() {
//         return itemName;
//     }
    
//     public void setItemName(String itemName) {
//         this.itemName = itemName;
//     }
    
//     public String getDescription() {
//         return description;
//     }
    
//     public void setDescription(String description) {
//         this.description = description;
//     }
    
//     public double getInitialPrice() {
//         return initialPrice;
//     }
    
//     public void setInitialPrice(double initialPrice) {
//         this.initialPrice = initialPrice;
//     }
    
//     public int getSellerId() {
//         return sellerId;
//     }
    
//     public void setSellerId(int sellerId) {
//         this.sellerId = sellerId;
//     }
// }

// // Define Auction class
// class Auction {
//     private int auctionId;
//     private int itemId;
//     private Date startTime;
//     private Date endTime;
//     private String status;
//     private int winnerId;
//     private Bid maxBid;

//     private HashMap<Integer,Bid> bids; // Key: bidder id, Value: B
    
//     // Constructor
//     public Auction(int auctionId, int itemId, Date startTime, Date endTime, String status, int winnerId) {
//         this.auctionId = auctionId;
//         this.itemId = itemId;
//         this.startTime = startTime;
//         this.endTime = endTime;

//         this.bids = new HashMap<>(); 
//     }
    
//     // Getters and setters
//     public int getAuctionId() {
//         return auctionId;
//     }
//     public void setAuctionId(int auctionId) {
//         this.auctionId = auctionId;
//     }
//     public int getItemId() {
//         return itemId;
//     }
//     public void setItemId(int itemId) {
//         this.itemId = itemId;
//     }
//     public Date getStartTime() {
//         return startTime;
//     }
//     public void setStartTime(Date startTime) {
//         this.startTime = startTime;
//     }
//     public Date getEndTime() {
//         return endTime;
//     }
//     public void setEndTime(Date endTime) {
//         this.endTime = endTime;
//     }
//     public String getStatus() {
//         return status;
//     }
//     public void setStatus(String status) {
//         this.status = status;
//     }  
//     public int getWinnerId() {
//         return winnerId;
//     }
//     public void setWinnerId(int winnerId) {
//         this.winnerId = winnerId;
//     }
//     public double getMaxBid() {
//         return maxBid != null ? maxBid.getBidAmount() : 0.0;
//     }
//     // methods

//     public void addBid(Bid bid)
//     {
//         bids.put(bid.getBidId(),bid);
//     }

//     public void printBids() {
//         for (HashMap.Entry<Integer, Bid> entry : bids.entrySet()) {
//             Bid bid = entry.getValue();
//             System.out.println(bid.getBidAmount());
//         }
//     }

//     public void findWinner() {
//         double maxBidAmount = Double.MIN_VALUE;
//         Bid winningBid = null;

//         for (HashMap.Entry<Integer, Bid> entry : bids.entrySet()) {
//             Bid bid = entry.getValue();
//             if (bid.getBidAmount() > maxBidAmount) {
//                 maxBidAmount = bid.getBidAmount();
//                 winningBid = bid;
//             }
//         }

//         if (winningBid != null) {
//             maxBid = winningBid;
//             winnerId = winningBid.getBidderId();
//         } else {
//             // Handle case where there are no bids
//             maxBid = null;
//             winnerId = 0; // or set to default winner
//         }
//     }
// }

// // Define Bid class
// class Bid {
//     private int bidId;
//     private int auctionId;
//     private int bidderId;
//     private double bidAmount;
//     private Date bidTime;
    
//     // Constructor
//     public Bid(int bidId, int auctionId, int bidderId, double bidAmount, Date bidTime) {
//         this.bidId = bidId;
//         this.auctionId = auctionId;
//         this.bidderId = bidderId;
//         this.bidAmount = bidAmount;
//         this.bidTime = bidTime;
//     }
    
//     // Getters and setters
//     public int getBidId() {
//         return bidId;
//     }
    
//     public void setBidId(int bidId) {
//         this.bidId = bidId;
//     }
    
//     public int getAuctionId() {
//         return auctionId;
//     }
    
//     public void setAuctionId(int auctionId) {
//         this.auctionId = auctionId;
//     }
    
//     public int getBidderId() {
//         return bidderId;
//     }
    
//     public void setBidderId(int bidderId) {
//         this.bidderId = bidderId;
//     }
    
//     public double getBidAmount() {
//         return bidAmount;
//     }
    
//     public void setBidAmount(double bidAmount) {
//         this.bidAmount = bidAmount;
//     }
    
//     public Date getBidTime() {
//         return bidTime;
//     }
    
//     public void setBidTime(Date bidTime) {
//         this.bidTime = bidTime;
//     }
// }

// // Define Service classes
// class UserService {
//     private HashMap<Integer,User> users;

//     UserService()
//     {
//         users = new HashMap<>();
//     }

//     public void createUser(User user) {
//         // Logic to create user (e.g., store in memory, print details)
//         System.out.println("User created: " + user.getUsername());

//         users.put(user.getUserId(),user);  
//     }
//     // Implement other service methods

// }

// class ItemService {
//     public void createItem(Item item) {
//         // Logic to create item
//         System.out.println("Item created: " + item.getItemName());
//     }
//     // Implement other service methods
// }

// class AuctionService {
//     public void createAuction(Auction auction) {
//         // Logic to create auction
//         System.out.println("Auction created for item: " + auction.getItemId());
//     }
//     // Implement other service methods
//     private void findWinner(Auction auction)
//     {
//         auction.findWinner();
//     }

//     public void closeAuction(Auction auction)
//     {
//         findWinner(auction);
//         auction.setStatus("closed");
//     }
// }

// class BidService {

//     public void placeBid(Bid bid,Auction auction) {
//         // Logic to place bid
//         auction.addBid(bid);

//         System.out.println("Bid placed on auction: " + bid.getAuctionId() + ", Amount: " + bid.getBidAmount());
//     }
//     // Implement other service methods
//     public void deleteBid(Auction auction,int userId)
//     {
//         // Logic to delete bid
//         // auction.deleteBid(userId);
//     }
// }

// // Main class (Entry Point)
// public class Main{
//     public static void main(String[] args) {
//         // Instantiate services and perform operations
//         UserService userService = new UserService();
//         ItemService itemService = new ItemService();
//         AuctionService auctionService = new AuctionService();
//         BidService bidService = new BidService();
        
//         // Example: Creating a user
//         User user = new User(1, "john_doe", "password123", "john@example.com", "buyer");
//         userService.createUser(user);
        
//         // create new item
//         Item item = new Item(1, "Laptop", "Brand new MacBook Pro", 2000, 1);
//         itemService.createItem(item);
        
//         // create new auction
//         Auction auction = new Auction(1, 1, new Date(), new Date(), "active", 0);
//         auctionService.createAuction(auction);

//         // place bid
//         Bid bid1 = new Bid(1, 1, 1, 2100, new Date());
//         Bid bid2 = new Bid(2, 1, 2, 2200, new Date());

//         bidService.placeBid(bid1,auction);
//         bidService.placeBid(bid2,auction);

//         // auction.printbids();
//         auctionService.closeAuction(auction);
//         System.out.println("Winner is: " + auction.getWinnerId() + " with bid amount: " + auction.getMaxBid());
//     }
// }
