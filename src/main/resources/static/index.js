/**********************************************************************************************************************
 * モデル
 **********************************************************************************************************************/

var Item = Backbone.Model.extend({
    urlRoot: "/apis/items",
    idAttribute: "itemId"
});

var Items = Backbone.Collection.extend({
    model: Item,
    url: "/apis/items"
});

/**********************************************************************************************************************
 * ビュー
 **********************************************************************************************************************/

var ItemView = Marionette.ItemView.extend({
    template: "#item-template",
    tagName: "tr"
});

var ItemsView = Marionette.CompositeView.extend({
    template : "#items-template",
    childView: ItemView,
    childViewContainer: "tbody"
});

/**********************************************************************************************************************
 * ルータ
 **********************************************************************************************************************/

var MyRouter = Marionette.AppRouter.extend({
    routes: {
        "": "toIndex",
        "index.html": "toIndex"
    },
    toIndex: function() {
        var items = new Items();
        items.fetch({
            success: function() {
                var view = new ItemsView({ collection: items });
                app.mainRegion.show(view);
            }
        });
    }
});

/**********************************************************************************************************************
 * アプリケーション
 **********************************************************************************************************************/

var app = new Marionette.Application();

app.addRegions({
    mainRegion: "#main-region"
});

app.on("start", function() {
    var router = new MyRouter();
    Backbone.history.start({ pushState: true });
});

$(function() {
    app.start();
});
