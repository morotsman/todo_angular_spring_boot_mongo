angular.module('todo', ['ngRoute', 'ngResource'])


        .service('TodoList', function ($resource) {
            return $resource("todos", {}, {
                get: {method: 'GET', cache: false, isArray: true}
            });
        })
        .service('Todo', function ($resource) {
            return $resource("todos/:todoId", {todoId: '@id'}, {
                save: {method: 'POST', cache: false, isArray: false},
                delete: {method: 'DELETE', cache: false, isArray: false}
            });
        })

        .config(function ($routeProvider) {

            $routeProvider
                    .when('/', {
                        controller: 'TodoController',
                        templateUrl: 'partials/todo.html'
                    })
                    .otherwise({
                        redirectTo: '/'
                    });
        })
        .controller('TodoController', function ($scope, TodoList, Todo, $q) {
            //load todos at startup

            var logError = function (errorResponse) {
                $scope.error = JSON.stringify(errorResponse);
            }

            var getTodos = function () {
                console.log("getTodos");
                TodoList.get({},
                        function (response) {
                            $scope.error = 'No error';
                            $scope.todos = response;
                        },
                        logError
                        );
            };

            var nothing = function(){};

            $scope.deleteTodos = function () {
                var results = $scope.todos
                        .filter(function (todo) {
                            return todo.completed;
                        })
                        .map(function (todo) {
                            return Todo.delete({todoId: todo.id}).$promise.then(nothing,logError);
                        });

                $q.all(results).then(getTodos);


            };

            $scope.remaining = function () {
                if (!$scope.todos) {
                    return 0;
                }
                return $scope.todos.filter(function (todo) {
                    return !todo.completed;
                }).length;
            };

            $scope.addTodo = function () {
                var todo = {
                    description: $scope.todoText,
                    completed: false
                };
                $scope.todoText = "";
                Todo.save({todoId: todo.id}, todo)
                        .$promise
                        .then(getTodos, logError);
            };

            getTodos();


        })
        ;


