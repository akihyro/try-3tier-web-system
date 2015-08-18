/**********************************************************************************************************************
 * モデル
 **********************************************************************************************************************/

var Item = Backbone.Model.extend({
    urlRoot: "/apis/items",
    idAttribute: "itemId"
});

/**********************************************************************************************************************
 * ビュー
 **********************************************************************************************************************/

var ItemView = Marionette.ItemView.extend({
    template: "#item-template",
    ui: {
        form: "form",
        enterButton: "#enterButton",
        deleteButton: "#deleteButton",
        backButton: "#backButton"
    },
    events: {
        "click @ui.enterButton": function(event) {
            var self = this;
            event.preventDefault();
            this.model.save({
                itemName: this.ui.form.find("input[name=itemName]").val(),
                itemValue: this.ui.form.find("input[name=itemValue]").val(),
                descriptions: this.ui.form.find("input[name=descriptions]").val()
            }, {
                success: function() {
                    self.ui.backButton.get(0).click();
                }
            });
        },
        "click @ui.deleteButton": function(event) {
            var self = this;
            event.preventDefault();
            this.model.destroy({
                dataType: "text",
                success: function() {
                    console.log("success");
                    self.ui.backButton.get(0).click();
                }
            });
        }
    }
});

/**********************************************************************************************************************
 * ルータ
 **********************************************************************************************************************/

var MyRouter = Marionette.AppRouter.extend({
    routes: {
        "new.html": "toNew",
        ":itemId.html": "toEdit"
    },
    toNew: function() {
        var item = new Item({
            itemId: null,
            itemName: "",
            itemValue: "",
            descriptions: ""
        });
        var view = new ItemView({ model: item });
        app.mainRegion.show(view);
    },
    toEdit: function(itemId) {
        var item = new Item({
            itemId: itemId
        });
        item.fetch({
            success: function() {
                var view = new ItemView({ model: item });
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
