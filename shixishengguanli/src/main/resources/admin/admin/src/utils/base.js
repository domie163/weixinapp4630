const base = {
    get() {
        return {
            url : "http://localhost:8080/shixishengguanli/",
            name: "shixishengguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/shixishengguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "实习生管理系统"
        } 
    }
}
export default base
