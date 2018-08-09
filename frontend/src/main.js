import Vue from 'vue'
import axios from 'axios';
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios);

var App = new Vue({
  el: '#app',
  data:{
    name: "",
    groupName: "",
    chosenBooks: [],
    students: [],
    groups: [],
    books: [],
    studentEditable: [],
    editable: false,
    showStudentEndpoint: "http://localhost:8081/server/show",
    showGroupEndpoint: "http://localhost:8081/server/group/show",
    showBookEndpoint: "http://localhost:8081/server/book/show",
    postStudentEndpoint: "http://localhost:8081/server/add",
    postEditStudentEndpoint: "http://localhost:8081/server/edit",
    removeStudentEndpoint: "http://localhost:8081/server/remove"

  },
  mounted() {
      let self = this;
      axios.get(this.showStudentEndpoint).then(function (value) {
        console.log(value);
        self.students = value.data
      });
      axios.get(this.showGroupEndpoint).then(function (value) {self.groups = value.data});
      axios.get(this.showBookEndpoint).then(function (value) {self.books = value.data});
    },

  methods: {

    addStudent: function () {
      var data =new FormData();
      data.append("name", this.name);
      data.append("group",this.groupName);
      data.append("books", this.chosenBooks);
      axios.post(this.postStudentEndpoint, data).then(function (value) { console.log("done") })
      location.reload(true)
    },
    setEditable: function (student) {
      this.studentEditable = student;
      this.name = this.studentEditable.name;
      this.groupName = this.studentEditable.group.name;
      var books = [];
      this.studentEditable.books.forEach(function (value, index, array) {
        books[index] = value.title
      });
      this.chosenBooks = books;
      this.editable = true;
      console.log(this.studentEditable);
    },
    setAddable: function () {
      this.editable = false;
      this.studentEditable = null;
      this.name = null;
      this.groupName = null;
    },
    editStudent: function () {
      var data = new FormData();
      data.append("name", this.name);
      data.append("group",this.groupName);
      data.append("books", this.chosenBooks);
      axios.post(this.postEditStudentEndpoint, data).then(function (value) { console.log(name + " has been edited") });
      location.reload(true)
    },
    removeStudent: function (id) {
      axios.get(this.removeStudentEndpoint + "/" + id).then(function (value) { console.log("done") })
      location.reload(true)
    }
  }
});

var Group = new Vue({
  el: "#group",
  data: {
    name: "",
    groups: [],
    addGroupEndpoint: "http://localhost:8081/server/group/add",
    editGroupEndpoint: "http://localhost:8081/server/group/edit",
    removeGroupEndpoint: "http://localhost:8081/server/group/remove"
  },
  mounted() {
      let self = this;
      axios.get(App.showGroupEndpoint).then(function (value) {
        self.groups = value.data;
      })
    },
  methods: {
    addGroup: function () {
      var data = new FormData();
      data.append("name", this.name);
      axios.post(this.addGroupEndpoint, data).then(function (value) { console.log("done") });
      location.reload(true)
    },
    removeGroup: function (id) {
      axios.get(this.removeGroupEndpoint + "/" + id).then(function (value) { console.log("done") });
      location.reload(true)
    }
  }
});

var Book = new Vue({
  el: "#book",
  data: {
    title: "",
    booksAll: [],
    addBookEndpoint: "http://localhost:8081/server/book/add"
  },
  mounted() {
      let self = this;
      axios.get(App.showBookEndpoint).then(function (value) {
        self.booksAll = value.data;
      })
    },
  methods: {
    addBook: function () {
      let self = this;
      var data = new FormData();
      data.append("title", this.title);
      axios.post(this.addBookEndpoint, data).then(function (value) {
        console.log(self.booksAll);
        location.reload(true)
      });
    }
  }

});


