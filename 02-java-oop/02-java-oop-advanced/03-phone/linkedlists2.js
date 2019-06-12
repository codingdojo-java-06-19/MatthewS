function SLNode(value) {
  this.value = value
  this.next = null
}

function SList() {
  this.head = null; this.back = function () {

    if (!this.head) {
      return null;
    }
    var runner = this.head;
    while (runner.next) {
      runner = runner.next;
    }
    return runner.val;
  }

  this.pushBack = function (value) {
    var newNode = new SLNode(value);
    if (!this.head) {
      this.head = newNode;
    } else {
      var runner = this.head;
      while (runner.next) {
        runner = runner.next;
      }
      runner.next = newNode;
    }
  }

  this.popBack = function () {
    if (!this.head) {
      return null;
    }
    var returnVal;
    if (!this.head.next) {
      returnVal = this.head.val;
      this.head = null;
      return returnVal;
    }
    var runner = this.head;
    while (runner.next.next) {
      runner = runner.next;
    }
    returnVal = runner.next.val;
    runner.next = null;
    return returnVal;
  }

  this.pushFront = function (value) {
    var oldHead = this.head;
    this.head = new SLNode(value);
    this.head.next = oldHead;

  }

  this.popFront = function () {
    var returnVal = null;
    if (this.head) {
      returnVal = this.head.val;
      this.head = this.head.next;
    } return returnVal;
  }

  this.contains = function (value) {
    var runner = this.head;
    while (runner) {
      if (runner.val === value) {
        return true;
      } runner = runner.next;
    }
    return false;
  }

  this.removeVal = function (value) {
    if (!this.head) {
      return false;
    }
    if (this.head.val === value) {
      this.head = this.head.next;
      return true;
    }
    var runner = this.head;
    while (runner.next) {
      if (runner.next.val === value) {
        runner.next = runner.next.next;
        return true;
      }
      runner = runner.next;
    }
    return false;
  }

  this.print = function () {
    console.log("beginning to print")
    var runner = this.head;
    while (runner) {
      console.log(runner.value);
      runner = runner.next;
    }
  }

  this.reverse = function () {
    var runner = this.head;
    var previous = null;
    while (runner) {
      var next = runner.next;
      runner.next = previous;
      previous = runner;
      runner = next;

    }
    this.head = previous;

  }

  this.kthlast = function (k) {
    var counter = 0;
    var runner = this.head;
    while (runner) {
      runner = runner.next;
      counter++;
    }

    if (k > counter) {
      return null;
    }
    var timer = counter - k;
    var finder = 0;

    runner = this.head;
    while (runner) {
      if (finder == timer) {
        return runner.value;
      }
      runner = runner.next;
      finder++;
    }
  }

  this.kthlast2 = function (k) {
    var runner = this.head;
    var runner2 = this.head;
    if (k <= 0) {
      return "k cannot be negative";
    }
    while (runner && k > 0) {
      console.log("runner " + runner.value);
      runner = runner.next;
      console.log("k " + k);
      k--

    }

    if (!runner) {
      return null;
    }

    while (runner) {
      console.log("runner2: " + runner2.value);
      runner2 = runner2.next;
      console.log("runner " + runner.value);
      runner = runner.next;

    }
    return runner2.value;
  }

}




var list = new SList()
var arr = [5, 4, 3, 2, 1];
for (var i = 0; i < arr.length; i++) {
  list.pushFront(arr[i]);
}
list.print();
console.log(list.kthlast2(1000));