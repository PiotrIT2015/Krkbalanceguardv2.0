# This is a sample Python script.
from os import listdir
# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def create_gallery():
    # Use a breakpoint in the code line below to debug your script.
    p=open('galery.html','w',encoding='utf-8')
    p.write('<!doctype html><html><meta charset="utf-8">')
    p.write('''
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    ''')
    styl='''<style>
    img{
    height:5cm;
    }
    </style>\n'''
    p.write(styl)
    p.write('</head><body>\n')
    p.write('''
    <div class="container">
        <div class="jumbotron">
        <center><h5>Ikigai</h5></center>
    ''')
    photo1 = listdir('img/')
    p.write('<center><img src="img/' + photo1[0] + '\n' + '"></center>\n')
    p.write('''    </div>
        <div class="row">
            <div class="col-sm-4">
    ''')
    photo2 = listdir('img/vocation/')
    p.write('<h3>Vocation:</h3>')
    for i in photo2:
        p.write('<img src="img/vocation/' + i + '\n' + '">\n')
    p.write('''       </div>
            <div class="col-sm-4">
    ''')
    photo3 = listdir('img/profession/')
    p.write('<h3>Profession:</h3>')
    for i in photo3:
        p.write('<img src="img/profession/' + i + '\n' + '">\n')
    p.write('''   </div>
        <div class="col-sm-4">
    ''')
    photo4 = listdir('img/passion/')
    p.write('<h3>Passion:</h3>')
    for i in photo4:
        p.write('<img src="img/passion/' + i + '\n' + '">\n')

    p.write(''' 
            <div class="row">
                <div class="col-sm-4">
        ''')
    photo5 = listdir('img/mission/')
    p.write('<h3>Mission:</h3>')
    for i in photo5:
        p.write('<img src="img/mission/' + i + '\n' + '">\n')
    p.write('''
        </div>
    </div>
    </div>>
    ''')

    p.write('''
        </div>
    </div>
    </div>
    ''')

    p.write('</body></html>')
    p.close()


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    create_gallery()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
