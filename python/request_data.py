import re
import mechanize

text = """
My python level is Novice. I have never written a web scraper 
or crawler. I have written a python code to connect to an api and 
extract the data that I want. But for some the extracted data I want to 
get the gender of the author. I found this web site 
http://bookblog.net/gender/genie.php but downside is there isn't an api 
available. I was wondering how to write a python to submit data to the 
form in the page and extract the return data. It would be a great help 
if I could get some guidance on this."""

browser = mechanize.Browser()
browser.open("http://bookblog.net/gender/genie.php")

browser.select_form(nr=0)
browser['text'] = text
browser['genre'] = ['nonfiction']

response = browser.submit()

content = response.read()

result = re.findall(
    r'<b>The Gender Genie thinks the author of this passage is:</b> (\w*)!', content)

print(result[0])
