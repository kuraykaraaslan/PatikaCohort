document.getElementById("search-button").addEventListener("click", function() {
    var query = document.getElementById("search-box").value;
    if (query.trim() !== "") {
        window.location.href = "https://www.google.com/search?q=" + encodeURIComponent(query);
    }
});