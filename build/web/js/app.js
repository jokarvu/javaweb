/*
    Javascript of Index.jsp
*/

// Load more new book
$(".load-more").click(function (e) { 
    e.preventDefault();
    var self = $(this);
    var start = $(this).closest(".card").find(".zoom").length;
    if (start < 4) {
        console.log("click");
        return;
    }
    var page = start/4 + 1;
    var category = $(this).attr('cat_id');
    if(category) {
        var data = {"cat": category, "page": page};
    } else {
        var type = $(this).attr('mode');
        var data = {"mode": type, "page": page};
    }
    var text = "";
    $.ajax({
        type: "get",
        url: "/shop/loadmore",
        data: data,
        dataType: "json",
        success: function (response) {
            response.forEach(book => {
                text += '<div class="card zoom mb-4">';
                text += '<img class="card-img-top" src="/shop/images/book/' + book.slug + '.gif" alt="Card image cap" height="400px">'
                text += '<div class="card-body">';
                text += '<h5 class="card-title">' + book.name + '</h5>';
                text += '<p class="card-text text-muted">' + book.author + '</p>';
                text += '<p class="card-text"><b>' + book.price + 'đ</b></p>';
                text += '</div>';
                text += '</div>';
            });
            self.closest(".card").find(".card-deck").append(text);
        }
    });
    // $(this).closest(".card").find(".zoom")
    var tmp = $(this).closest(".card").find(".zoom").length - 1;
});