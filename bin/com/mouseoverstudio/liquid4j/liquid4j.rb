require "rubygems"
require "liquid"

def parse()
  Liquid::Template.parse($text)
end