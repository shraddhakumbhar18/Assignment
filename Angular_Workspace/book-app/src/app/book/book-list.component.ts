import { Component, OnInit } from '@angular/core';
import { BookService } from './book.service';
import { Book } from './book';
import { ActivatedRoute } from '@angular/router';

@Component({
    
    //selector: "book-list",
    templateUrl: "./book-list.Component.html"
})
export class BookListComponent implements OnInit {
 
    books:Book[];

    constructor(private bookService: BookService, 
                private route: ActivatedRoute){}
    
    ngOnInit(): void{
        this.route.paramMap.subscribe((map)=>{
            let category = map.get("category");
            console.log(category);

            this.bookService.findBooksByCategory(category).subscribe((data) => {
                this.books = data;
                console.log(data);      
            });
        });
    }
    
}