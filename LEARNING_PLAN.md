# Java CLI Tic-Tac-Toe with QUIC Multiplayer - Learning Plan

A comprehensive learning plan for building a Java CLI tic-tac-toe game with QUIC-based multiplayer networking, designed for a Go engineer learning Java.

## Phase 1: Java Foundation

### Task 1: Learn Java basics and CLI application structure
- Study Java syntax differences from Go (classes vs structs, inheritance, interfaces)
- Learn Maven/Gradle build systems
- Understand Java package structure and imports
- Practice with Scanner for CLI input and `System.out` for output

#### Project structure:
``` bash 
com.matthew_sandoval.t3mesh
├── app           // Entry point
│   └── Main.java
├── game          // Core Tic-Tac-Toe logic
│   ├── Board.java
│   ├── Player.java
│   └── Game.java
├── network       // P2P networking & messaging
│   ├── Peer.java
│   ├── ConnectionManager.java
│   └── Message.java
├── cli           // Command-line input/output
│   ├── ConsoleUI.java
│   └── InputParser.java
└── util          // Helper utilities
    └── ConsoleUtils.java
```

1. Main.java

    - Launches the application, initializes CLI, game, and network.

2. cli Package

    - Handles user input/output only.
    - Example: prints board, reads moves, shows network messages.

3. game Package

    - Handles the game rules and state.
    - No networking or I/O inside these classes — fully testable.

4. network Package

    - Handles peer discovery, TCP/UDP communication, and message serialization.

    - Communicates moves/events to CLI or game classes via method calls or events.

5. util Package

    - Small helpers: console colors, input validation, random helpers, etc.

## Phase 2: Core Game Logic

### Task 2: Implement basic tic-tac-toe game logic
**Files:** `game/Board.java`, `game/Player.java`, `game/Game.java`
- Create Board class with 2D array representation → `game/Board.java`
- Implement win condition checking algorithms → `game/Board.java`
- Build Player class and game state management → `game/Player.java`, `game/Game.java`
- Add move validation logic → `game/Board.java`

### Task 3: Create CLI interface
**Files:** `cli/ConsoleUI.java`, `cli/InputParser.java`, `util/ConsoleUtils.java`
- Design terminal-based board display → `cli/ConsoleUI.java`
- Implement user input parsing and validation → `cli/InputParser.java`
- Add game loop and turn management → `cli/ConsoleUI.java`
- Create menu system for game options → `cli/ConsoleUI.java`

## Phase 3: Networking Research

### Task 4: Research Java QUIC libraries
**Files:** Documentation and research notes
- Explore Netty with QUIC support (netty-incubator-transport-native-quic)
- Study Java NIO for async networking concepts
- Compare with Go's QUIC libraries you know
- Understand Java's CompletableFuture for async operations

### Task 5: Design network protocol
**Files:** `network/Message.java`
- Define message types (join game, make move, game state sync) → `network/Message.java`
- Choose serialization (JSON, Protocol Buffers, or Java Serialization) → `network/Message.java`
- Design packet structure and error handling → `network/Message.java`
- Plan for game state consistency → `network/Message.java`

## Phase 4: Network Implementation

### Task 6: Implement QUIC client-server architecture
**Files:** `network/ConnectionManager.java`, `network/Peer.java`
- Create basic QUIC server for game hosting → `network/ConnectionManager.java`
- Build QUIC client for connecting to games → `network/ConnectionManager.java`
- Implement message serialization/deserialization → `network/Message.java`
- Add connection management and heartbeat → `network/ConnectionManager.java`, `network/Peer.java`

### Task 7: Add NAT traversal and hole punching
**Files:** `network/ConnectionManager.java`, `network/Peer.java`
- Research STUN/TURN servers for NAT discovery → `network/ConnectionManager.java`
- Implement UDP hole punching technique → `network/ConnectionManager.java`
- Add fallback relay server option → `network/ConnectionManager.java`
- Handle different NAT types (Full Cone, Restricted, etc.) → `network/ConnectionManager.java`

## Phase 5: Game Features

### Task 8: Implement game session management
**Files:** `game/Game.java`, `network/ConnectionManager.java`, `cli/ConsoleUI.java`
- Create lobby system for player matching → `cli/ConsoleUI.java`, `network/ConnectionManager.java`
- Add unique game room IDs → `game/Game.java`
- Implement spectator mode → `game/Game.java`, `cli/ConsoleUI.java`
- Build reconnection logic for dropped connections → `network/ConnectionManager.java`

### Task 9: Add error handling and recovery
**Files:** `network/ConnectionManager.java`, `util/ConsoleUtils.java`
- Handle network timeouts and failures → `network/ConnectionManager.java`
- Implement graceful disconnection → `network/ConnectionManager.java`
- Add validation for malformed packets → `network/Message.java`
- Create logging system for debugging → `util/ConsoleUtils.java`

### Task 10: Test and optimize
**Files:** Test files, `network/ConnectionManager.java`
- Test across different network conditions → Test files
- Measure latency and optimize packet size → `network/ConnectionManager.java`
- Add performance monitoring → `util/ConsoleUtils.java`
- Test NAT traversal with various router configurations → Test files

## Key Java Concepts to Focus On

- **Collections**: Use ArrayList, HashMap for game state
- **Concurrency**: ExecutorService, CompletableFuture for networking
- **Exception Handling**: Try-catch blocks, custom exceptions
- **Streams**: For functional programming patterns similar to Go
- **Interfaces**: Java's approach to contracts (similar to Go interfaces)

## Libraries to Explore

- **Netty QUIC**: For QUIC protocol implementation
- **Jackson**: For JSON serialization
- **SLF4J + Logback**: For logging
- **JUnit 5**: For testing

## Development Strategy

This plan progresses from basic Java concepts to advanced networking, letting you build confidence while learning. Each task builds on the previous ones, similar to how you'd approach a complex system in Go.

## Getting Started

1. Set up your Java development environment (JDK 17+, IntelliJ IDEA/VS Code)
2. Initialize a Maven or Gradle project
3. Start with Task 1 and work through each phase sequentially
4. Create branches for each major feature to track your progress
5. Test thoroughly at each phase before moving to the next

Good luck with your Java learning journey!