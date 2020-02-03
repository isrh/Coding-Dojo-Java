//Devuelve la suma de 1 a N. Por ejemplo,  Sum1toN(3) devolverá la suma de 1+2+3, la cual es 6
//sum1toN(255) devuelve la suma de todos los números de 1 a 255
function Sum1toN(n){

    var sum=0;
    var x=1;

    while (x<=n){

        sum=sum+x;

        x=x+1;
        
    }

    return sum;


}
//devuelve la suma del primer y último número en el array
function sumFirstLast(arr){

    var sum=0;

    var first=arr[0];
    var last=arr[arr.length-1];

    sum=first + last;

    return sum;

}

//función que devuelva el número más grande del array. Por ejemplo, returnLargest([1,3,10]) 
//debería devolver 10 y returnLargest([-2,-5,-10]) debería devolver -2. Una vez que hayas escrito la prueba,
// ejecútala (sin escribir toda la función para asegurarte de que fallen todas las pruebas), luego completa 
//la función cerciorándote de que pase todas las pruebas. 


function findMayor(arr){

    var mayor=arr[0];

    for(var i=0; i<arr.length;i++){

        if(arr[i]>mayor){
            mayor=arr[i];
        }
    }

    return mayor;

}
    
describe("Sum1toN", function() { 
    it("should return 3 when we pass 2 as an argument", function() { 
        expect(Sum1toN(2)).toEqual(3); 
    }); 
    it("should return 6 when we pass 3 as an argument", function() { 
        expect(Sum1toN(3)).toEqual(6); 
    }); 
    it("should return 10 when we pass 4 as an argument", function() { 
        expect(Sum1toN(4)).toEqual(10); 
    }); 

    it("should return 55 when we pass 4 as an argument", function() { 
        expect(Sum1toN(10)).toEqual(55); 
    }); 
});
    
describe("sumFirstLast", function() { 
    it("should return 3 when we pass [1,2] as an argument", function() { 
        expect(sumFirstLast([1,2])).toEqual(3); 
    }); 
    it("should return 10 when we pass [2,3,8] as an argument", function() { 
        expect(sumFirstLast([2,3,8])).toEqual(10); 
    }); 
    it("should return -10 when we pass [-6,23,3,-4] as an argument", function() { 
        expect(sumFirstLast([-6,23,3,-4])).toEqual(-10); 
    }); 

    it("should return -4 when we pass [-6,23,3,-4] as an argument", function() { 
        expect(sumFirstLast([6,23,3,-10])).toEqual(-4); 
    }); 

    it("should return 2 when we pass [-6,23,3,-4] as an argument", function() { 
        expect(sumFirstLast([6,23,3,-4])).toEqual(2); 
    }); 
});

describe("findMayor", function() { 
    it("should return 3 when we pass [1,2,3] as an argument", function() { 
        expect(findMayor([1,2,3])).toEqual(3); 
    }); 
    it("should return 10 when we pass [2,3,10,8] as an argument", function() { 
        expect(findMayor([2,3,10,8])).toEqual(10); 
    }); 
    it("should return -3 when we pass [-6,-23,-3,-4] as an argument", function() { 
        expect(findMayor([-6,-23,-3,-4])).toEqual(-3); 
    }); 

});
