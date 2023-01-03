# This is a sample Python script.
#!/usr/bin/python
import socket
import select
import sys
import matplotlib.pyplot as plt


# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def netscan1(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.
    if len(sys.argv) != 4:
        print("Usage - ./banner_grab.py [Target-IP] [First Port] [Last Port]")
        print("Example - ./banner_grab.py 10.0.0.5 1 100")
        print("Example will grab banners for TCP ports 1 through 100 on 10.0.0.5")
        sys.exit()
        ip = sys.argv[1]
        start = int(sys.argv[2])
        end = int(sys.argv[3])
        for port in range(start, end):
            try:
                bangrab = socket.socket(socket.AF_INET,
                                        socket.SOCK_STREAM)
                bangrab.connect((ip, port))
                ready = select.select([bangrab], [], [], 1)
                if ready[0]:
                    print("TCP Port " + str(port) + " -" + bangrab.recv(4096))
                    plt.plot(port, bangrab)
                    plt.show()
                bangrab.close()
            except:
                pass

def netscan2(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.
    if len(sys.argv) != 4:
        print("Usage - ./banner_grab.py [Target-IP] [First Port] [Last Port]")
        print("Example - ./banner_grab.py 10.0.0.5 1 100")
        print("Example will grab banners for TCP ports 1 through 100 on 10.0.0.5")
        sys.exit()

    ip = sys.argv[1]
    start = int(sys.argv[2])
    end = int(sys.argv[3])

    for port in range(start, end):
        try:
            bangrab = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            bangrab.connect((ip, port))
            ready = select.select([bangrab], [], [], 1)
            if ready[0]:
                print("TCP Port " + str(port) + " - " + bangrab.recv(4096))
                plt.plot(port, bangrab)
                plt.show()
            bangrab.close()
        except:
            pass

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    netscan1('PyCharm')
    netscan2('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
