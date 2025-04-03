# model - pojo

## Player
- id
- name
- role (bolwer,bats-man)
- playing yeaer


## team
- id
- name
- Player<player>

## match-format
- id
- type
- county

## score-board
- id
- match no
- [team names]
- win/loss team result
- socre


# services

## Player-service
- addPlayer()
-


so idea is first get player add into ArrayList
add team with id name and all thing
after that we add player into map with team id and whole player obj that give all the player regarding team

so problem is adding data into 1st team was good it store into map and show it but adding another team data that goes into team 1 also and team 1 data goes into team 2 means both return all the data in map
