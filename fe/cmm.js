var friendUl = document.getElementById("friend-list");

var friends = [
    { name: 'Ray', favColor: 'red', background: 'blue' },
    { name: 'Oscar', favColor: 'orange', background: 'brown' },
    { name: 'Gwen', favColor: 'green', background: 'yellow' },
    { name: 'Bob', favColor: 'blue', background: 'red' },
    { name: 'Marie', favColor: 'magenta', background: 'purple' }
]

var randomFriends = [];
while (friends.length > 0) {
    var idx = Math.floor(Math.random() * friends.length);
    var movingFriend = friends.splice(idx, 1)[0];
    randomFriends.push(movingFriend);
}

for (var idx = 0; idx < randomFriends.length; idx++) {
    var friend = randomFriends[idx];
    var friendLiElem = document.createElement("li");

    var friendSpanElem = document.createElement("span");
    friendSpanElem.setAttribute("style", "font-style: oblique; font-size: 20px; color:" + friend.favColor + "; background-color:" + friend.background)
    friendSpanElem.setAttribute("class", "fade")
    friendLiElem.appendChild(friendSpanElem);

    var friendName = document.createTextNode(friend.name);
    friendSpanElem.append(friendName);

    friendUl.appendChild(friendLiElem);
}