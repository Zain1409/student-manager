var vueInstance = new Vue({
    el: '#app',
    data: {
        title: 'Dien thoai samsung'
    },
    methods: {
        say: function(text){
            return 'Hello ' + text;
        }
    }
});
console.log(vueInstance);
setTimeout(()=>{
    vueInstance.title = "Dient thoai apple"
},3000)