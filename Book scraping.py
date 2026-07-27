import csv
import requests
from bs4 import BeautifulSoup
from urllib.parse import urljoin


# URLs of page 1 and page 3 of the Nonfiction category
page_urls = [
    (
        1,
        "https://books.toscrape.com/catalogue/category/books/nonfiction_13/index.html"
    ),
    (
        3,
        "https://books.toscrape.com/catalogue/category/books/nonfiction_13/page-3.html"
    )
]

# Convert rating words into numbers
rating_values = {
    "One": 1,
    "Two": 2,
    "Three": 3,
    "Four": 4,

    "Five": 5
}

books_data = []


def scrape_page(page_number, page_url):
    """Scrape book information from one category page."""

    try:
        response = requests.get(page_url, timeout=15)
        response.raise_for_status()

    except requests.RequestException as error:
        print(f"Error while accessing page {page_number}: {error}")
        return

    soup = BeautifulSoup(response.text, "html.parser")

    # Select all book cards
    books = soup.select("article.product_pod")

    for book in books:
        # Book title
        title_element = book.select_one("h3 a")
        title = title_element.get("title", "").strip()

        # Book price
        price_element = book.select_one("p.price_color")
        price = price_element.get_text(strip=True)

        # Availability
        availability_element = book.select_one("p.instock.availability")
        availability = availability_element.get_text(
            " ",
            strip=True
        )

        # Rating
        rating_element = book.select_one("p.star-rating")
        rating_classes = rating_element.get("class", [])

        rating_word = "Not Available"

        for value in rating_classes:
            if value in rating_values:
                rating_word = value
                break

        rating_number = rating_values.get(rating_word, 0)

        # Product URL
        relative_link = title_element.get("href", "")
        product_url = urljoin(page_url, relative_link)

        # Store the book information
        books_data.append({
            "Page Number": page_number,
            "Category": "Nonfiction",
            "Book Title": title,
            "Price": price,
            "Rating": rating_number,
            "Availability": availability,
            "Product URL": product_url
        })

    print(
        f"Page {page_number} scraped successfully. "
        f"{len(books)} books found."
    )


# Scrape page 1 and page 3
for page_number, page_url in page_urls:
    scrape_page(page_number, page_url)


# CSV filename
csv_filename = "nonfiction_books_page_1_and_3.csv"

# CSV column headings
fieldnames = [
    "Page Number",
    "Category",
    "Book Title",
    "Price",
    "Rating",
    "Availability",
    "Product URL"
]


# Save the collected information into a CSV file
try:
    with open(
        csv_filename,
        "w",
        newline="",
        encoding="utf-8-sig"
    ) as csv_file:

        writer = csv.DictWriter(
            csv_file,
            fieldnames=fieldnames
        )

        writer.writeheader()
        writer.writerows(books_data)

    print("\nScraping completed successfully!")
    print(f"Total books collected: {len(books_data)}")
    print(f"CSV file created: {csv_filename}")

except OSError as error:
    print(f"Unable to create the CSV file: {error}")
