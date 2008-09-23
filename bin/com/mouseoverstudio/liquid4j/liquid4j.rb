require "rubygems"
require "liquid"
require "rhyme"

def parse()
  Liquid::Template.parse($text)
end

def render(template, hash)
	template.render hash
end

def to_hash(map)
	Rhyme.translate(map)
end