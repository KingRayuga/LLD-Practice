# Cricbuzz - Low-Level Design (LLD)

## Flow
Cricbuzz is a ball-by-ball event streaming application. After each ball, scores and stats are updated in real-time.  

### Features:
- Users can see multiple live matches.  
- After opening a match, users can view:
  - The **current innings score**.  
  - The **full scorecard** with player details and metadata.  
  - The **individual stats** of a player when clicked.  

## Objects Identified
- **Match**  
- **MatchManager**  
- **Scorecard**  
- **Innings**  
- **Team**  
- **Player**  
- **Person**  
- **User**  
- **StatsCard**  
- **Comments**  
- **BallObservee**  
- **StatsObserver**  

![image](https://github.com/user-attachments/assets/6d469c90-6b7f-46bf-bcc9-f653e35acec2)
