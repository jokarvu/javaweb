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

// Add to cart (session)
$(".fa-cart-plus").click(function (e) { 
    e.preventDefault();
    var id = $(this).attr("id");
    $.ajax({
        type: "get",
        url: "/shop/addToCart",
        data: {"id": id},
        dataType: "json",
        success: function (response) {
            var text = "";
            text += '<div class="card-body m-0 p-3">';
            text += '<div class="row">';
            text += '<div class="col-md-4">';
            text += '<img src="/shop/images/book/' + response.slug + '.gif" width="100%">';
            text += '</div>';
            text += '<div class="col-md-8">';
            text += '<p class="card-title">' + response.name + "</p>";
            text += '<p class="card-text">' + response.price + "đ</p>";
            text += '</div>';
            text += '</div>';
            text += '</div>';
            $("#cart-body").append(text);
            var total = parseInt($("#cart-total").html()) + response.price;
            $("#cart-total").html(total);
        }
    });
});


// Load cart
$(document).ready(function () {
    $.ajax({
        type: "get",
        url: "/shop/loadCart",
        dataType: "json",
        success: function (response) {
            var cart = response;
            var text = "";
            var total = 0;
            if (cart.length == 0) {
                text += "Không có sản phẩm nào";
                $("#cart-body").append(text);
                return
            }
            cart.forEach(book => {
                text += '<div class="card-body m-0 p-3">';
                text += '<div class="row">';
                text += '<div class="col-md-4">';
                text += '<img src="/shop/images/book/' + book.slug + '.gif" width="100%">';
                text += '</div>';
                text += '<div class="col-md-8">';
                text += '<p class="card-title">' + book.name + "</p>";
                text += '<p class="card-text">' + book.price + "đ</p>";
                text += '</div>';
                text += '</div>';
                text += '</div>';
                total += book.price;
            })
            $("#cart-body").append(text);
            $("#cart-total").html(total);
        }
    });
});

// Show cart
$("#cart-icon").click(function (e) {
    e.preventDefault();
    $("#cart").toggle();
});