import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecentralizedGamePrototypeMonitor {
    
    // Game Data Model
    private class Game {
        private String gameId;
        private String gameName;
        private String gameType; // e.g. first-person shooter, strategy, etc.
        private List<Player> players;
        private Map<String, GameEvent> events;
        
        public Game(String gameId, String gameName, String gameType) {
            this.gameId = gameId;
            this.gameName = gameName;
            this.gameType = gameType;
            this.players = new ArrayList<>();
            this.events = new HashMap<>();
        }
        
        public void addPlayer(Player player) {
            players.add(player);
        }
        
        public void addEvent(GameEvent event) {
            events.put(event.getEventId(), event);
        }
    }
    
    // Player Data Model
    private class Player {
        private String playerId;
        private String playerName;
        private String gameRole; // e.g. player, moderator, admin
        
        public Player(String playerId, String playerName, String gameRole) {
            this.playerId = playerId;
            this.playerName = playerName;
            this.gameRole = gameRole;
        }
    }
    
    // Game Event Data Model
    private class GameEvent {
        private String eventId;
        private String eventType; // e.g. playerJoined, playerLeft, gameStarted, etc.
        private String data; // additional event data
        
        public GameEvent(String eventId, String eventType, String data) {
            this.eventId = eventId;
            this.eventType = eventType;
            this.data = data;
        }
    }
    
    // Decentralized Game Prototype Monitor
    private Map<String, Game> games;
    private Blockchain blockchain;
    
    public DecentralizedGamePrototypeMonitor() {
        this.games = new HashMap<>();
        this.blockchain = new Blockchain();
    }
    
    public void addGame(Game game) {
        games.put(game.getGameId(), game);
        blockchain.addBlock(new Block(game.getGameId(), game.getGameName()));
    }
    
    public void updateGame(Game game) {
        games.put(game.getGameId(), game);
        blockchain.addBlock(new Block(game.getGameId(), game.getGameName()));
    }
    
    public Game getGame(String gameId) {
        return games.get(gameId);
    }
    
    // Blockchain Data Model
    private class Blockchain {
        private List<Block> blocks;
        
        public Blockchain() {
            this.blocks = new ArrayList<>();
        }
        
        public void addBlock(Block block) {
            blocks.add(block);
        }
        
        public List<Block> getBlocks() {
            return blocks;
        }
    }
    
    // Block Data Model
    private class Block {
        private String blockId;
        private String gameId;
        private String gameName;
        private String timestamp;
        
        public Block(String gameId, String gameName) {
            this.gameId = gameId;
            this.gameName = gameName;
            this.timestamp = String.valueOf(System.currentTimeMillis());
        }
    }
}