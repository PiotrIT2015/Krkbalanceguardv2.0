# This is a sample Python script.
import tornado.web
import tornado.ioloop
# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
class uploadHandler(tornado.web.RequestHandler):
    def get(self):
        self.render("index.html")

    def post(self):
        files = self.request.files["imgFile"]
        for f in files:
            fh = open("./img/{f.filename}","wb")
            fh.write(f.body)
            fh.close()
# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    app = tornado.web.Application([
        ("/",uploadHandler),
        ("./img/(.*)",tornado.web.StaticFileHandler,{"path":"img"})
    ])

    app.listen(8080)
    print("Listening on port 8080")

    tornado.ioloop.IOLoop.instance().start()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
